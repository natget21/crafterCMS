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








// // Define the path where the Category content type is located
// def categoryContentTypePath = "/site/components/categories" 

// // Define a query to get all categories
// def categoriesQuery = """
// {
//   "query": {
//     "match_all": {}
//   }
// }
// """

// // Execute the query to fetch all categories
// def categoryResults = queryService.search(SiteContext.current.site, categoriesQuery, categoryContentTypePath, 0, 100)

// // Process the query results to extract necessary details
// def categories = categoryResults.documents.collect { category ->
//     [
//         id: category["localId"],
//         name: category["name_s"] // Adjust based on your field name for the category title
//     ]
// }

// // Return the response
// return [
//     status: 200,
//     categories: categories
// ]


// //get pages ----works
// def topNavItems = [:]
// def siteDir = siteItemService.getSiteTree("/site/website", 2)

// if (siteDir) {
//     def dirs = siteDir.childItems
//     dirs.each { dir ->
//         def dirName = dir.getStoreName()
//         def dirItem = siteItemService.getSiteItem("/site/website/${dirName}/index.xml")
//         if (dirItem != null) {
//             def dirDisplayName = dirItem.queryValue('internal-name')
//             topNavItems.put(dirName, dirDisplayName)
//         }
//     }
// }

// return topNavItems

// get macroCategories ----works

// Initialize the QueryService
def queryService = applicationContext.getBean("queryService")

// Define the path where Macro Categories are stored
def macroCategoryPath = "/site/components/macro_categories" // Adjust based on your site structure

// Define the query to get all macro categories
def macroCategoryQuery = """
{
  "query": {
    "match_all": {}
  }
}
"""

// Execute the query to fetch all macro categories
def macroCategoryResults = queryService.search(SiteContext.current.site, macroCategoryQuery, macroCategoryPath, 0, 100)

// Process the query results to extract necessary details
def macroCategories = macroCategoryResults.documents.collect { macroCategory ->
    [
        id: macroCategory["localId"],
        name: macroCategory["macro_category_name_s"]  // Adjust field name as needed for the macro category name
    ]
}

// Return the response
return [
    status: 200,
    macroCategories: macroCategories
]