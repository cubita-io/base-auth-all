<!DOCTYPE html>
<html lang="en">
<head>
    <title>SpringBoot + Freemarker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Hello boy,</h1><br>
<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
</body>
</html>
