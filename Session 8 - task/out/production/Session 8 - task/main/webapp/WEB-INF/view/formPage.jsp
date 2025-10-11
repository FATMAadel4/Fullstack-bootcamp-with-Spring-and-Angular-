<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>User Form</title>

       <!-- Bootstrap CSS -->
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   </head>

   <body class="bg-light d-flex align-items-center" style="min-height: 100vh;">
   <div class="container">
       <div class="row justify-content-center">
           <div class="col-md-6 col-lg-5">
               <div class="card shadow-lg border-0 rounded-4">
                   <div class="card-body p-4">
                       <h3 class="text-center mb-4 text-primary fw-bold">User Registration</h3>

                       <form:form action="processForm" modelAttribute="userModel">

                           <!-- Username -->
                           <div class="mb-3">
                               <label class="form-label">Username</label>
                               <form:input path="userName" class="form-control" placeholder="Enter username"/>
                           </div>

                           <!-- Password -->
                           <div class="mb-3">
                               <label class="form-label">Password</label>
                               <form:password path="password" class="form-control" placeholder="Enter password"/>
                           </div>

                           <!-- Country -->
                           <div class="mb-3">
                               <label class="form-label">Country</label>
                               <form:select path="country" class="form-select">
                                   <form:option value="Egypt" label="Egypt" />
                                   <form:option value="Brazil" label="Brazil" />
                                   <form:option value="Saudia Arabia" label="KSA" />
                               </form:select>
                           </div>

                           <!-- Programming Language -->
                           <div class="mb-3">
                               <label class="form-label d-block mb-2">Preferred Programming Language</label>
                               <div class="form-check form-check-inline">
                                   <form:radiobutton path="programmingLanguage" value="Java" class="form-check-input"/>
                                   <label class="form-check-label">Java</label>
                               </div>
                               <div class="form-check form-check-inline">
                                   <form:radiobutton path="programmingLanguage" value="C#" class="form-check-input"/>
                                   <label class="form-check-label">C#</label>
                               </div>
                               <div class="form-check form-check-inline">
                                   <form:radiobutton path="programmingLanguage" value="PHP" class="form-check-input"/>
                                   <label class="form-check-label">PHP</label>
                               </div>
                               <div class="form-check form-check-inline">
                                   <form:radiobutton path="programmingLanguage" value="Ruby" class="form-check-input"/>
                                   <label class="form-check-label">Ruby</label>
                               </div>
                           </div>

                           <!-- Operating System -->
                           <div class="mb-3">
                               <label class="form-label d-block mb-2">Preferred Operating System</label>
                               <div class="form-check">
                                   <form:checkbox path="operatingSystem" value="Linux" class="form-check-input"/>
                                   <label class="form-check-label">Linux</label>
                               </div>
                               <div class="form-check">
                                   <form:checkbox path="operatingSystem" value="Mac OS" class="form-check-input"/>
                                   <label class="form-check-label">Mac OS</label>
                               </div>
                               <div class="form-check">
                                   <form:checkbox path="operatingSystem" value="MS Windows" class="form-check-input"/>
                                   <label class="form-check-label">MS Windows</label>
                               </div>
                           </div>

                           <!-- Submit -->
                           <div class="d-grid mt-4">
                               <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                           </div>

                       </form:form>
                   </div>
               </div>
           </div>
       </div>
   </div>


   </body>

</html>

