<html>
<head>
    <title>Fruit Picker!</title>
</head>
<body>
<form action="/favorite_fruit" method="post">
    <p>What is your favorite fruit?</p>
    <#list fruits as fruit>
    <p>
        <input type="radio" name="fruit" value="${fruit}">${fruit}</input>

    </p>
    </#list>
    <input type="submit" value="submit"></input>
</form>
</body>
</html>