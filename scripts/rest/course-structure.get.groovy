


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
def contentModel = pageContext.contentModel // Or templateModel.get("contentModel")

// Assuming the contentModel has a descriptor XML
def descriptorXml = contentModel.getAsXml()

def fields = []
descriptorXml.fields.field.each { field ->
    fields << [
        name: field.@name.toString(),
        type: field.@type.toString(),
        label: field.@label?.toString() ?: "",
        required: field.@required?.toBoolean() ?: false
    ]
}

return fields