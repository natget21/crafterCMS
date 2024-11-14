import groovy.xml.XmlSlurper

// Check if contentLoader is available
def contentLoader = binding.getVariable("contentLoader") ?: applicationContext?.getBean("contentLoader")

if (!contentLoader) {
    throw new RuntimeException("ContentLoader is not available")
}

def fetchCategoryDetails(categoryPath) {
    // Load the content from the given category path
    def categoryFile = contentLoader.loadContent(categoryPath)
    if (!categoryFile) throw new Exception("Category not found at path: " + categoryPath)

    // Parse the XML content to extract category details
    def xmlContent = new XmlSlurper().parseText(categoryFile.contentAsString)
    return [
        name: xmlContent.categoryname_s?.text(),
        description: xmlContent.description?.text()
    ]
}

def fetchSubCategories() {
    // Load the subcategories content
    def subCategories = contentLoader.loadContent("/site/components/sub_categories")
    def subCategoryList = []

    if (subCategories) {
        subCategories.each { subCategory ->
            def details = [:]
            details['name'] = subCategory.subCategoryName_s?.text()

            // Fetch the referenced categories for this subcategory
            def categories = []
            subCategory.category_o?.item?.each { item ->
                def categoryDetails = fetchCategoryDetails(item.key.text())
                categories << categoryDetails
            }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList
}

// Fetch the subcategories and return the result
def result = fetchSubCategories()
return result