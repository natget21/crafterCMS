import scripts.libs.CommonLifecycleApi
import groovy.xml.XmlSlurper

// Parameters for CommonLifecycleApi
def contentLifecycleParams = [:]
contentLifecycleParams.site = site
contentLifecycleParams.path = path
contentLifecycleParams.user = user
contentLifecycleParams.contentType = contentType
contentLifecycleParams.contentLifecycleOperation = contentLifecycleOperation
contentLifecycleParams.contentLoader = contentLoader
contentLifecycleParams.applicationContext = applicationContext

// Instantiate CommonLifecycleApi
def controller = new CommonLifecycleApi(contentLifecycleParams)

// Define method to fetch category details
def fetchCategoryDetails(categoryPath) {
    def categoryFile = contentLoader.loadContent(categoryPath)
    if (categoryFile) {
        def xmlContent = new XmlSlurper().parseText(categoryFile.contentAsString)
        return [
            name: xmlContent.categoryname_s?.text(),
            description: xmlContent.description?.text()
        ]
    }
    return null
}

// Define method to fetch subcategories and their associated categories
def getSubCategories() {
    def subCategoryList = []
    def subCategories = contentLoader.loadContent("/site/components/sub_categories")

    if (subCategories) {
        subCategories.each { subCategory ->
            def details = [:]
            details['name'] = subCategory.subCategoryName_s?.text()

            def categories = []
            subCategory.category_o?.item?.each { item ->
                def categoryDetails = fetchCategoryDetails(item.key.text())
                if (categoryDetails) {
                    categories << categoryDetails
                }
            }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList
}

// Endpoint handler for custom API request
return getSubCategories()