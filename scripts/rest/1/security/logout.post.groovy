import org.springframework.security.core.context.SecurityContextHolder
import org.craftercms.sites.ecommerce.util.SessionUtil

def user = SessionUtil.getUser()

if (user) {
  logger.debug("Logging out user {}", user.email)
  SecurityContextHolder.clearContext()
  session.invalidate()
  return true
} else {
  logger.debug("No user is logged in")
  return true
}
