<%@page language="java" %>

<html>
<body>

<div class="login-container">
    <h2>Customer Login</h2>
    <input type="email" id="email" placeholder="Email" required />
    <input type="password" id="password" placeholder="Password" required />
    <button onclick="login()">Login</button>
    <div class="error" id="error"></div>
</div>

</body>
</html>