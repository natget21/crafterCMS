import groovy.util.XmlSlurper

def result = [:]
def componentPath = params.path

if (componentPath) {
    def component = siteItemService.getSiteItem(componentPath)

    if (component) {
        def xmlContent = new XmlSlurper().parseText(component.getAsXml())
        def fields = []

        xmlContent.fields.field.each { field ->
            fields << [
                name: field.@name.toString(),
                type: field.@type.toString(),
                label: field.@label.toString()
            ]
        }

        result.success = true
        result.fields = fields
    } else {
        result.success = false
        result.message = "Component not found at path: ${componentPath}"
    }
} else {
    result.success = false
    result.message = "Parameter 'path' is required."
}
