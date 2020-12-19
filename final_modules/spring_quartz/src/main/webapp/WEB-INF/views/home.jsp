<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel='stylesheet' href='webjars/fullcalendar/3.5.1/dist/fullcalendar.css' />
<script src="webjars/jquery/2.0.3/jquery.min.js"></script>
<script src='webjars/moment/2.19.1/min/moment.min.js'></script>
<script src='webjars/fullcalendar/3.5.1/dist/fullcalendar.js'></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#calendar').fullCalendar({
      events: {
        url : '/api/event/all'
      }
    });
  });
</script>
<body>
 <div id='calendar'></div>
</body>
</html>
