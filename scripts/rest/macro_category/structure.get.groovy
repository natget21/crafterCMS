
// Define the path to the content type descriptor
def contentTypePath = "/config/content-types/categories.content-type.xml" // Adjust for your setup

// Retrieve the content type descriptor using siteItemService
def contentTypeDescriptor = siteItemService.getSiteItem(contentTypePath)

// Check if the descriptor is null (file doesn't exist)
if (!contentTypeDescriptor) {
    return [status: 404, message: "Content type not found at path: ${contentTypePath}"]
}

// Parse the XML content type descriptor
def contentTypeXml = xmlParser.parseText(contentTypeDescriptor.text)

// Extract metadata and fields
def contentTypeName = contentTypeXml.@name
def fields = contentTypeXml.fields.field.collect { field ->
    [
        name: field.@name,
        type: field.@type,
        label: field.label?.text(),
        required: field.required?.text() == "true"
    ]
}

// Return the structure
return [
    status: 200,
    contentTypeName: contentTypeName,
    fields: fields
]
