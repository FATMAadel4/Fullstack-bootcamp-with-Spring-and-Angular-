package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    // عرض الصفحة الرئيسية
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "homePage"; // JSP → /WEB-INF/view/homePage.jsp
    }

    // عرض فورم إضافة منتج
    @GetMapping("/addProductForm")
    public String showAddForm(Model model) {
        Product product = new Product();
        ProductDetails details = new ProductDetails();

        // تهيئة قيم افتراضية لتجنب null
        details.setAvailable(false);
        details.setPrice(null);
        details.setManufacturer("");
        details.setName("");
        details.setExpirationDate(new Date());

        product.setProductDetails(details);
        model.addAttribute("product", product);
        return "addProductForm";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product  ) {

        if (product.getProductDetails() == null) {
            product.setProductDetails(new ProductDetails());        // اربطي الاتجاهين

        }
        // خلي الاسم في التفاصيل نفس اسم المنتج الرئيسي
        product.getProductDetails().setName(product.getName());

        productService.addProduct(product);
        return "redirect:/";
    }


    // عرض تفاصيل منتج معين
    @GetMapping("/showProductDetails")
    public String showProductDetails(@Valid @RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewDetailsPage"; // JSP → /WEB-INF/view/viewProductDetails.jsp
    }
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@Valid @RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);

         if (product.getProductDetails() == null) {
            product.setProductDetails(new ProductDetails());
        }

        model.addAttribute("product", product);
        return "updateDetailsForm"; // JSP → /WEB-INF/view/updateDetailsForm.jsp
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        if (product.getProductDetails() == null) {
            product.setProductDetails(new ProductDetails());        // اربطي الاتجاهين

        }
        product.getProductDetails().setName(product.getName());

        productService.updateProduct(product);
        return "redirect:/"; // يرجع للصفحة الرئيسية بعد التحديث
    }



    // حذف منتج
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
