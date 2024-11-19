<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en" data-craftercms-preview="${modePreview?c}">
<head>
  <meta charset="utf-8">
  <title>Registration</title>
  <link rel="stylesheet" href="/static-assets/css/vendor/bootstrap-3.3.7.min.css">
  <style>
    body { padding-top: 50px; }
  </style>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <@crafter.head/>
</head>
<body>
  <@crafter.body_top/>
  
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <h2>Create an Account</h2>
          <form id="userForm" method="POST" >
          <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" class="form-control" required />
          </div>
          <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" required />
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <br>
        <a href="/path/to/login" class="btn btn-link">Already have an account? Log in here</a>
      </div>
    </div>
  </div>

  <@crafter.body_bottom/>

</body>
</html>