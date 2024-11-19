<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en" data-craftercms-preview="${modePreview?c}">
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="/static-assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static-assets/css/login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <@crafter.head/>
</head>
<body>
    <@crafter.body_top/>

    <div class="cont">
        <Form class="form sign-in" action="/crafter-security-login" method="post">
         <input type="hidden" name="redirect" value="/" />
            <h2>Welcome</h2>
            <label>
                <span>Username</span>
                <input type="username" name="username" class="form-control" required />
            </label>
            <label>
                <span>Password</span>
                <input type="password" name="password" class="form-control" required />
            </label>
             <label>
    <input type="checkbox" name="rememberMe" value="true" id="rememberMe">Remember Me</input>
 </label>
            <p class="forgot-pass"><a href="/path/to/forgot-password">Forgot password?</a></p>
            <button type="submit" class="submit btn btn-primary">Sign In</button>
        </Form>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h3>Don't have an account? Please Sign up!</h3>
                </div>
                <div class="img__text m--in">
                    <h3>If you already have an account, just sign in.</h3>
                </div>
                <div class="img__btn">
                    <span class="m--up">Sign Up</span>
                    <span class="m--in">Sign In</span>
                </div>
            </div>
            <div class="form sign-up">
                <h2>Create your Account</h2>
                <label>
                    <span>Name</span>
                    <input type="text" name="name" class="form-control" required />
                </label>
                <label>
                    <span>Email</span>
                    <input type="email" name="email" class="form-control" required />
                </label>
                <label>
                    <span>Password</span>
                    <input type="password" name="password" class="form-control" required />
                </label>
                <button type="submit" class="submit btn btn-primary">Sign Up</button>
            </div>
        </div>
    </div>

    <script>
        document.querySelector('.img__btn').addEventListener('click', function () {
            document.querySelector('.cont').classList.toggle('s--signup');
        });
    </script>

    <@crafter.body_bottom/>
</body>
</html>