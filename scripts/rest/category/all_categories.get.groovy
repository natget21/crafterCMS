// import java.util.Date

// if (!session) {
//     session = request.getSession(true)
// }

// def date = session.getAttribute("date")
// if (!date) {
//     date = new Date()

//     session.setAttribute("date", date)
// }

// return ["date": date]


// import org.craftercms.engine.service.context.SiteContext
// import org.craftercms.engine.service.QueryService

// // Initialize the QueryService for querying content
// def queryService = applicationContext.getBean("queryService")

// // Define the product content type path
// def productContentTypePath = "/site/components/items/course" // Adjust this path based on your setup

// // Define the query to get all product entries
// def productsQuery = """
// {
//   "query": {
//     "match_all": {}
//   }
// }
// """

// // Query to fetch all products
// def productResults = queryService.search(SiteContext.current.site, productsQuery, productContentTypePath, 0, 100)

// // Collect data for each product including its category and subcategory details
// def productsWithCategories = productResults.documents.collect { product ->
//     // // Get the category and subcategory references
//     // def categoryRef = product["category_o"][0]
//     // def subcategoryRef = product["subcategory_o"][0]

//     // // Query the category details
//     // def categoryDetails = queryService.getSiteItem(SiteContext.current.site, categoryRef)

//     // // Query the subcategory details
//     // def subcategoryDetails = queryService.getSiteItem(SiteContext.current.site, subcategoryRef)

//     // Return the product details with its category and subcategory information
//     return [
//         id: product["localId"],
//         title: product["nome_s"], // Adjust this based on your content model
//         // category: categoryDetails ? [
//         //     id: categoryDetails["localId"],
//         //     name: categoryDetails["name_s"] // Adjust field name as needed
//         // ] : null,
//         // subcategory: subcategoryDetails ? [
//         //     id: subcategoryDetails["localId"],
//         //     name: subcategoryDetails["name_s"] // Adjust field name as needed
//         // ] : null
//     ]
// }

// // Return the response
// return [
//     status: 200,
//     products: productsWithCategories
// ]








import org.craftercms.engine.service.context.SiteContext
import org.craftercms.engine.service.QueryService

// Initialize the QueryService to query content
def queryService = applicationContext.getBean("queryService")

// Define the path where the Category content type is located
def categoryContentTypePath = "/site/components/categories" 

// Define a query to get all categories
def categoriesQuery = """
{
  "query": {
    "match_all": {}
  }
}
"""

// Execute the query to fetch all categories
def categoryResults = queryService.search(SiteContext.current.site, categoriesQuery, categoryContentTypePath, 0, 100)

// Process the query results to extract necessary details
def categories = categoryResults.documents.collect { category ->
    [
        id: category["localId"],
        name: category["name_s"] // Adjust based on your field name for the category title
    ]
}

// Return the response
return [
    status: 200,
    categories: categories
]

