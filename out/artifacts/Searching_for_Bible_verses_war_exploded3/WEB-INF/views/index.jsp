<%
    // 현재 페이지(currentPage)는 0-based, 즉 0이면 1페이지를 의미한다고 가정
    // totalPages도 1부터 시작이 아니라 '페이지 개수'를 나타냄. 예) 35면 0..34까지 존재

    Integer totalPages = (Integer) request.getAttribute("totalPages");
    Integer currentPage = (Integer) request.getAttribute("currentPage");
    String keyword = request.getParameter("keyword");

    if (totalPages == null) totalPages = 0;
    if (currentPage == null) currentPage = 0;
    if (keyword == null) keyword = "";

    // 1) 블록 사이즈(한번에 보여줄 페이지 번호 수)
    int blockSize = 10;

    // 2) 현재 블록 (예: 페이지가 0~9면 0번 블록, 10~19면 1번 블록)
    int currentBlock = currentPage / blockSize;

    // 3) 블록의 시작/끝 페이지 번호
    int startPage = currentBlock * blockSize;           // 예: 블록이 0이면 0, 1이면 10, 2면 20...
    int endPage = startPage + blockSize - 1;            // 예: start가 0이면 9, 10이면 19...

    // 실제 totalPages를 넘지 않도록 보정
    if (endPage >= totalPages - 1) {
        endPage = totalPages - 1;
    }
%>

<!-- 페이지 블록 표시 (totalPages가 2페이지 이상일 때만 표시한다고 가정) -->
<% if (totalPages > 1) { %>
<ul style="list-style:none;">
    <!-- 이전(Prev) 블록 링크: 현재 블록이 0보다 클 때만 보여주기 -->
    <%
        if (currentBlock > 0) {
            // 이전 블록의 마지막 페이지 번호
            int prevPage = startPage - 1;
    %>
    <li style="display:inline; margin-right:5px;">
        <a href="?keyword=<%= keyword %>&page=<%= prevPage %>"
           style="text-decoration:none; border:1px solid #ccc; padding:3px 5px;">
            &lt;
        </a>
    </li>
    <%
        }
    %>

    <!-- 실제 페이지 번호들 표시 -->
    <%
        for (int i = startPage; i <= endPage; i++) {
    %>
    <li style="display:inline; margin-right:5px;">
        <%
            // 현재 페이지면 배경색 다르게
            if (i == currentPage) {
        %>
        <a href="?keyword=<%= keyword %>&page=<%= i %>"
           style="text-decoration:none; border:1px solid #ccc; padding:3px 5px; background:lightgray;">
            <%= (i + 1) %>
        </a>
        <%
        } else {
        %>
        <a href="?keyword=<%= keyword %>&page=<%= i %>"
           style="text-decoration:none; border:1px solid #ccc; padding:3px 5px;">
            <%= (i + 1) %>
        </a>
        <%
            }
        %>
    </li>
    <%
        } // end for
    %>

    <!-- 다음(Next) 블록 링크: endPage가 (totalPages-1)보다 작을 때만 -->
    <%
        if (endPage < totalPages - 1) {
            // 다음 블록의 첫 페이지
            int nextPage = endPage + 1;
    %>
    <li style="display:inline; margin-right:5px;">
        <a href="?keyword=<%= keyword %>&page=<%= nextPage %>"
           style="text-decoration:none; border:1px solid #ccc; padding:3px 5px;">
            &gt;
        </a>
    </li>
    <%
        }
    %>
</ul>
<% } %>
