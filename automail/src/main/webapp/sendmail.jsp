<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head><title>Send E-Mail Form</title></head>
<style>* {font-family:"宋体" ; font-size: 14px }</style>
<body>
<p><font color="red">发送邮件的程序</font></p>
  <form action="<%=request.getContextPath()%>/WEB-INF/sendMail" method="post">
    <table cellspacing="2" cellpadding="2" border="0">      
      <tr><td>收件人</td>
        <td><input type="text" name="to" size="30"></td>
      </tr>
      <tr><td>发件人</td>
        <td><input type="text" name="from" size="30"></td>
      </tr>
      <tr><td>主题</td>
        <td><input type="text" name="subject" size="30"></td>
      </tr>
      <tr><td valign="top">正文</td>
        <td><textarea cols="50" rows="15" name="body"></textarea></td>
      </tr>
      <tr><td></td><td>
    <input type="submit" value="提交"><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form>
</body>
</html>