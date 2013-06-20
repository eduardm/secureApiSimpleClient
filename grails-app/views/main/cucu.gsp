<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ApiSigner test app</title>
</head>

<body>
<div id="container">
    <h1>API Signer test app</h1>

    <form method="POST">
        <p>
            <label>Data</label>
            <input type="text" name="data">
        </p>

        <p>
            <label>Secret</label>
            <input type="text" name="secret">
        </p>


        <p>
            <input type="submit" name="Code">
        </p>
    </form>
    <g:if test="${result}">
        <hr />
        <div>
            <h3>Server response:</h3>

            <p>${result}</p>
        </div>
    </g:if>
</div>
</body>
</html>