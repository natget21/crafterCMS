import groovy.xml.XmlSlurper

// Ensure siteItemService is available for fetching content
def siteItemService = binding.getVariable("siteItemService") ?: applicationContext?.getBean("siteItemService")

if (!siteItemService) {
    throw new RuntimeException("siteItemService is not available")
}

def fetchSubCategories() {
    // Load the subcategories content from a specified path
    def subCategoriesItem = siteItemService.getSiteItem("/site/components/sub_categories")
    def subCategoryList = []

    if (subCategoriesItem) {
        def subCategories = new XmlSlurper().parseText(subCategoriesItem.contentAsString)
        subCategories.each { subCategory ->
            def details = [:]
            details['name'] = subCategory.subCategoryName_s?.text()
            // Add additional fields as needed from subCategory here
            subCategoryList << details
        }
    }
    return subCategoryList
}

// Return the fetched subcategories as the API response
def result = fetchSubCategories()
return result