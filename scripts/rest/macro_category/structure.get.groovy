// // Define the path to the content type descriptor
// def contentTypePath = "/site/components/categories.content-type.xml" // Adjust path

// // Fetch the content type descriptor
// def contentTypeDescriptor = siteItemService.getSiteItem(SiteContext.current.site, contentTypePath)

// // Parse the content type XML to extract structure
// def xmlParser = new XmlParser()
// def contentTypeXml = xmlParser.parseText(contentTypeDescriptor.text)

// // Extract fields
// def fields = contentTypeXml.fields.field.collect { field ->
//     [
//         name: field.@name,
//         type: field.@type,
//         label: field.label.text(),
//         required: field.required?.text() == "true"
//     ]
// }

// // Return structure
// return [
//     status: 200,
//     contentTypeName: contentTypeXml.@name,
//     fields: fields
// ]


// Path to the folder containing all content items of the type
def contentTypePath = "/site/components/categories" // Adjust this based on your content structure

// Query an item to inspect its structure
def items = siteItemService.getSiteTree(contentTypePath, 1)

logger.error("items are "+items)

def sampleItem = items?.first()  // Use the first item as a sample

def fields = sampleItem?.properties?.keySet()?.collect { fieldName ->
    def fieldValue = sampleItem.properties.get(fieldName)?.value
    [name: fieldName, value: fieldValue]
}

// Return the fields in JSON format
return [
    status: 200,
    fields: fields ?: "No items found at ${contentTypePath}"
]