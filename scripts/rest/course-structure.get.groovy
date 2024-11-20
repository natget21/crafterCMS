


// // def descriptor = siteItemService.getSiteItem("/site/components/items/course.meta.xml")

// //     return descriptor
// import groovy.xml.XmlSlurper

// def componentPath = "/site/components/items/course"
// def result = [:]

// def component = siteItemService.getSiteItem(componentPath)

// if (component?.item?.descriptorUrl) {
//     def descriptorPath = component.item.descriptorUrl
//     def descriptor = siteItemService.getSiteTree(descriptorPath)
//     if (descriptor?.getAsXml()) {
//         def xmlContent = new XmlSlurper().parseText(descriptor.getAsXml())
//         def fields = []

//         xmlContent.fields.field.each { field ->
//             fields << [
//                 name: field.@name.toString(),
//                 type: field.@type.toString(),
//                 label: field.@label?.toString() ?: "",
//                 required: field.@required?.toBoolean() ?: false
//             ]
//         }

//         result.success = true
//         result.fields = fields
//     } else {
//         result.success = false
//         result.message = "Descriptor XML not found at ${descriptorPath}."
//     }
// } else {
//     result.success = false
//     result.message = "Descriptor URL missing for component at ${componentPath}."
// }

// return result
import groovy.json.JsonSlurper
import groovy.xml.XmlSlurper

// Set up the path to the component
def componentPath = "/site/components/items/course"  // Adjust this to the desired component

// API endpoint for the descriptor
def apiUrl = "http://localhost:8080/api/1/content_store/descriptor"  // Adjust the URL to your CrafterCMS instance

// Construct the request to get the descriptor XML for the component
def url = new URL("${apiUrl}?path=${componentPath}")
def connection = url.openConnection()

// Set HTTP method to GET
connection.setRequestMethod("GET")

// Check if the request is successful (status code 200)
if (connection.getResponseCode() == 200) {
    // Parse the response
    def response = connection.getInputStream().getText()
    
    // Parse the XML content of the descriptor
    def xmlContent = new XmlSlurper().parseText(response)
    
    // Prepare a list to store the fields and their properties
    def fields = []
    
    // Loop through the fields in the XML (assuming fields are defined under <fields>)
    xmlContent.fields.field.each { field ->
        fields << [
            name: field.@name.toString(),
            type: field.@type.toString(),
            label: field.@label?.toString() ?: "No label",
            required: field.@required?.toBoolean() ?: false
        ]
    }
    
    // Return the fields as part of the result
    return [
        success: true,
        fields: fields
    ]
} else {
    // If the request was not successful, return an error message
    return [
        success: false,
        message: "Failed to fetch descriptor for ${componentPath}. Response code: ${connection.getResponseCode()}"
    ]
}