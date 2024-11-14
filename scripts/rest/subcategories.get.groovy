def contentLoader = binding.getVariable("contentLoader") ?: applicationContext.getBean("contentLoader")
def content = contentLoader.loadContent("/path/to/some/content")
return content ? "Content found" : "Content not found"