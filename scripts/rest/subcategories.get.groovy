import groovy.xml.XmlSlurper

// Ensure siteItemService is available for content fetching
def siteItemService = binding.getVariable("siteItemService") ?: applicationContext?.getBean("siteItemService")

if (!siteItemService) {
    throw new RuntimeException("siteItemService is not available")
}

def fetchCategoryDetails(categoryPath) {
    // Load the category content using siteItemService
    def categoryItem = siteItemService.getSiteItem(categoryPath)
    if (!categoryItem) throw new Exception("Category not found at path: " + categoryPath)

    // Parse the XML content to extract category details
    def xmlContent = new XmlSlurper().parseText(categoryItem.contentAsString)
    return [
        name: xmlContent.categoryname_s?.text(),
        description: xmlContent.description?.text()
    ]
}

def fetchSubCategories() {
    // Load the subcategories content using siteItemService
    def subCategoriesItem = siteItemService.getSiteItem("/components/sub_categories")
 
    return subCategoriesItem
}

// Fetch the subcategories and return the result
def result = fetchSubCategories()
return siteItemService.getSiteItem("/components/sub_categories")