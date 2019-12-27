# This project is a spring boot project.
# Import this project in your IDE as a Maven project.
# Mvn command Clean and Install(Building the application)
# Run this project upon right clicking on the project and select run project.
# After application successfully got build and the application is started.
# Access the application upon pasting the URL in the browser.
# For the items other than groceries --
# 1. For employee of the store -- discount 30%
#    --- url is http://localhost:8080/getDiscountedBill/999/employeeofstore?itemCategory=cloth
# 2. For user is affiliated to the store -- discount 10%
# --- url is http://localhost:8080/getDiscountedBill/999/affiliatedtothestore?itemCategory=cloth
# 3. For user being the customer of the store over two years -- discount 5%
# --- url is http://localhost:8080/getDiscountedBill/999/customerforovertwoyears?itemCategory=cloth
# For the items belong to the groceries department.
# only default discount of $5 is applicable no other discounts are applicable which are mentioned above.
# --- url to access the total bill for groceries item is http://localhost:8080/getDiscountedBill/999/customerforovertwoyears?itemCategory=groceries 