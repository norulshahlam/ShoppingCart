
<html>
  <head>
         <style type="text/css">
  <%@include file="css/main.css" %>
</style>
         <style type="text/css">
  <%@include file="css/contact.css" %>
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
      <div class="form">
        <form action="../../GeneralFeedbackPath" method="Post">
          <h1>Contact Us!</h1>  
            <p>Please let us know what we can do to provide you with a better shopping experience</p>
              <div id="logo" class="icon-ic-drafts-24px"></div>
                <input name="name" type="text" placeholder="Name" id="name" required/>
                <input name="email" type="email" placeholder="Email" id="email" required/>
                <input name="Contact Number" type="text" placeholder="Contact Number" id="Contact Number" required/>
	                <h4><center>Feedback Category : </h4>
					<select name="Feedback Category">
					    <option value="Product">Product</option>
					    <option value="Delivery">Delivery</option>
					    <option value="Services">Services</option>
					    <option value="Others">Others</option>
					    </center>
					</select>
                <textarea name="text" placeholder="Message"></textarea>
                <input type="submit" value="Send" id="button-blue"/>
              </div>
        </form>
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