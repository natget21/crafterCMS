


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
import groovy.xml.MarkupBuilder
import groovy.xml.MarkupBuilderHelper

def sitemap = []
def excludeContentTypes = ['/component/level-descriptor']

parseSiteItem = { siteItem ->
    if (siteItem.isFolder()) {
        def children = siteItem.childItems;
        children.each { child ->
            parseSiteItem(child);
        }
    } else {
        def contentType = siteItem.queryValue('content-type')
        if (!excludeContentTypes.contains(contentType)) {
            def storeUrl = siteItem.getStoreUrl();
            def location = urlTransformationService.transform('storeUrlToFullRenderUrl', storeUrl);
            sitemap.add(location);
        }
    }
}

def siteTree = siteItemService.getSiteTree("/site/website", -1)
if (siteTree) {
    def items = siteTree.childItems;
    items.each { siteItem ->
        parseSiteItem(siteItem);
    }
    return items
}

// response.setContentType("application/xml;charset=UTF-8")

// def writer = response.getWriter()
// def xml = new MarkupBuilder(writer)
// def xmlHelper = new MarkupBuilderHelper(xml)

// xmlHelper.xmlDeclaration(version:"1.0", encoding:"UTF-8")

// xml.urlset(xmlns:"http://www.sitemaps.org/schemas/sitemap/0.9") {
//     sitemap.each { location ->
//         url {
//             loc(location)
//             changefreq("daily")
//         }
//     }
// }

// response.flushBuffer()

// return null