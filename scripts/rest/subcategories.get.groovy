def fetchSubCategories() {
    // Fetch the subcategories folder item
    def subCategoriesFolder = siteItemService.getSiteItem("/site/components/sub_categories")
    def subCategoryList = []

    // Ensure the folder exists and has child items
    if (subCategoriesFolder && subCategoriesFolder.childItems) {
        subCategoriesFolder.childItems.each { child ->
            // Fetch and parse each child item in the folder
            def childItem = siteItemService.getSiteItem(child.storeUrl)
            if (childItem && childItem.contentAsString) {
                def xmlContent = new XmlSlurper().parseText(childItem.contentAsString)

                // Extract necessary details from each subcategory item
                def details = [
                    name: xmlContent.subCategoryName_s?.text() ?: "Unnamed Subcategory",
                    description: xmlContent.description?.text() ?: "No description available"
                ]
                subCategoryList << details
            }
        }
    }
    return subCategoryList
}

// Fetch the subcategories and return the result
def result = fetchSubCategories()
return result