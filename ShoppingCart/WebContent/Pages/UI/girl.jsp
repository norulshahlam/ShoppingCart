
<html>
  <head>
            <style type="text/css">
  <%@include file="css/main.css" %>
</style>
         <style type="text/css">
  <%@include file="css/girl.css" %>
</style>
  </head>
  <body>
  <div class="main">
    <div style="width:98%;">
      <!-- Header -->
      <div class="one">
        <ul>
         <li class="one"><a href="index.jsp">| Home |</a></li>
          <li class="one"><a href="product.jsp">| Product |</a></li>
          <li class="one"><a href="contact.jsp">| Contact Us |</a></li>
          <li class="one"><a href="about.jsp">| About Us |</a></li>
          <%if(session.getAttribute("Username") != null){ %>
          <li class="one"><a href="../../ProfileControllerPath" method="get">| Profile |</a></li>
          <li class="one"><a href="../Cart/ViewCart.jsp">| Cart |</a></li>
          <li class="one"><a href="../../ViewHistoryController">| View History |</a></li>
          <li class="one"><a href="../../ViewOrderController">| View Orders |</a></li>
          <% } %>
          
          <%if(session.getAttribute("Username") == null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="login" onclick="location.href = '../../Pages/Login/login.jsp'"> Log In </button></li>
       	  <li class="two"><button style="margin-top:15px; margin-left:3px" name="Signup" onclick="location.href = '../../Pages/Signin/signup.jsp'"> Sign up </button></li>
          <% } %>
           
          <%if(session.getAttribute("Username") != null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="Logout" onclick="location.href = '../../Pages/Login/logOut.jsp'"> Log Out </button></li>
          <% } %>
          <form action="../../searchControllerPath" method="post">
          <input name="searchBar" class="search" type="search" placeholder="Search" autocomplete="off" value="" />
          </form>
        </ul>
      </div>
      <br>
      <p class="girl">Girl</p>
      <div class="sag" style="width: 28%; border:0px solid #808080;">
      <h4 class="kat2" style="margin-top:0px">Your Items</h4>
          <ul class="menu">
            <li>Item 1</li>
            <br><br>
            <li>Item 2</li>
            <br><br>
            <li>Item 3</li>
          </ul>
  </div>
<div id="grid" class="outer">
  <div class="row">
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 1</div>
          </div>
        </div>
      </div>
    </div>
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 2</div>
          </div>
        </div>
      </div>
    </div>
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 3</div><br><br>
          </div>
        </div>
      </div>
    </div> 
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 4</div>
          </div>
        </div>
      </div>
    </div>
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 5</div>
          </div>
        </div>
      </div>
    </div>
    <div class="col">
      <div class="outerfit">
        <div class="overtop">
          <div class="fill_a">
            <div class="img"><img src="" /></div>
            <div class="title">Product 6</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
       <footer class="footer">
        <div class="center" style="width:100%; height: auto; border:1px solid #808080;">
            <h4>Online shopping</h4>
            Done By JJ, Farid, Johnathan, Shah, Haritha, Shahul & Ambuj
        </footer>
    </div>
  </body>
</html>
</div>