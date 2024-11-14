def contentLoader = applicationContext.getBean("contentLoader")  // Or try getting it in a different way
def content = contentLoader.loadContent("/site/components/sub_categories")
return content ? "Content found" : "Content not found"