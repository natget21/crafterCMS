import scripts.libs.CommonLifecycleApi;

def contentLifecycleParams =[:];
contentLifecycleParams.site = site;
contentLifecycleParams.path = path;
contentLifecycleParams.user = user;
contentLifecycleParams.contentType = contentType;
contentLifecycleParams.contentLifecycleOperation = contentLifecycleOperation;
contentLifecycleParams.contentLoader = contentLoader;
contentLifecycleParams.applicationContext = applicationContext;

def controller = new CommonLifecycleApi(contentLifecycleParams);
controller.execute();
// Inject JavaScript file reference into the placeholder field
def scriptPath = "/static-assets/js/categoryfilter.js"
contentModel.put("scriptInjection", "<script src='" + scriptPath + "'></script>");