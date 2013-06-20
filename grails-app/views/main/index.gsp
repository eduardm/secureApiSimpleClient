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
            <label>Consumer key</label>
            <input type="text" name="key">
        </p>

        <p>
            <label>Consumer secret</label>
            <input type="text" name="secret">
        </p>

        <p>
            <label>Request url</label>
            <input type="text" name="url">
        </p>

        <p>
            <label>Method</label>
            <select name="method">
                <option value="GET">GET</option>
            </select>
        </p>

        <p>
            <input type="submit" name="Make request">
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