import org.craftercms.sites.ecommerce.util.SessionUtil

import static org.craftercms.sites.ecommerce.util.RequestUtil.parse

def req = parse(request, ["email", "password"])

def user = SessionUtil.getUser()

if (user) {
  logger.debug("User {} already logged in", user.email)
  return user
} else {
  logger.debug("Starting login process")
  return applicationContext.customerService.authenticate(session, req.email, req.password)
}
