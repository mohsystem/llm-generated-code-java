package llama3.task135;

import org.junit.jupiter.api.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.Principal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task135Test {

    // -------------------- MOCK CLASSES --------------------

    static class MockRequest implements HttpServletRequest {
        private final Map<String, String> params = new HashMap<>();
        private final MockSession session = new MockSession();

        public void setParameter(String name, String value) {
            params.put(name, value);
        }

        @Override
        public Object getAttribute(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String getCharacterEncoding() {
            return "";
        }

        @Override
        public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

        }

        @Override
        public int getContentLength() {
            return 0;
        }

        @Override
        public long getContentLengthLong() {
            return 0;
        }

        @Override
        public String getContentType() {
            return "";
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        @Override public String getParameter(String name) {
            return params.get(name);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return null;
        }

        @Override
        public String[] getParameterValues(String s) {
            return new String[0];
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return Map.of();
        }

        @Override
        public String getProtocol() {
            return "";
        }

        @Override
        public String getScheme() {
            return "";
        }

        @Override
        public String getServerName() {
            return "";
        }

        @Override
        public int getServerPort() {
            return 0;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return null;
        }

        @Override
        public String getRemoteAddr() {
            return "";
        }

        @Override
        public String getRemoteHost() {
            return "";
        }

        @Override
        public void setAttribute(String s, Object o) {

        }

        @Override
        public void removeAttribute(String s) {

        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return null;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String s) {
            return null;
        }

        @Override
        public String getRealPath(String s) {
            return "";
        }

        @Override
        public int getRemotePort() {
            return 0;
        }

        @Override
        public String getLocalName() {
            return "";
        }

        @Override
        public String getLocalAddr() {
            return "";
        }

        @Override
        public int getLocalPort() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            return null;
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            return false;
        }

        @Override
        public AsyncContext getAsyncContext() {
            return null;
        }

        @Override
        public DispatcherType getDispatcherType() {
            return null;
        }

        @Override public HttpSession getSession() {
            return session;
        }

        @Override
        public String changeSessionId() {
            return "";
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            return false;
        }

        @Override
        public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
            return false;
        }

        @Override
        public void login(String s, String s1) throws ServletException {

        }

        @Override
        public void logout() throws ServletException {

        }

        @Override
        public Collection<Part> getParts() throws IOException, ServletException {
            return List.of();
        }

        @Override
        public Part getPart(String s) throws IOException, ServletException {
            return null;
        }

        @Override
        public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
            return null;
        }

        @Override public HttpSession getSession(boolean create) {
            return session;
        }

        public MockSession getMockSession() {
            return session;
        }

        @Override
        public String getAuthType() {
            return "";
        }

        @Override
        public Cookie[] getCookies() {
            return new Cookie[0];
        }

        @Override
        public long getDateHeader(String s) {
            return 0;
        }

        @Override
        public String getHeader(String s) {
            return "";
        }

        @Override
        public Enumeration<String> getHeaders(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return null;
        }

        @Override
        public int getIntHeader(String s) {
            return 0;
        }

        @Override public String getMethod() {
            return "POST";
        }

        @Override
        public String getPathInfo() {
            return "";
        }

        @Override
        public String getPathTranslated() {
            return "";
        }

        @Override
        public String getContextPath() {
            return "";
        }

        @Override
        public String getQueryString() {
            return "";
        }

        @Override
        public String getRemoteUser() {
            return "";
        }

        @Override
        public boolean isUserInRole(String s) {
            return false;
        }

        @Override
        public Principal getUserPrincipal() {
            return null;
        }

        @Override
        public String getRequestedSessionId() {
            return "";
        }

        @Override
        public String getRequestURI() {
            return "";
        }

        @Override
        public StringBuffer getRequestURL() {
            return null;
        }

        @Override
        public String getServletPath() {
            return "";
        }

        // other methods stubbed as needed
    }

    static class MockSession implements HttpSession {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public long getCreationTime() {
            return 0;
        }

        @Override
        public String getId() {
            return "";
        }

        @Override
        public long getLastAccessedTime() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public void setMaxInactiveInterval(int i) {

        }

        @Override
        public int getMaxInactiveInterval() {
            return 0;
        }

        @Override
        public HttpSessionContext getSessionContext() {
            return null;
        }

        @Override public Object getAttribute(String name) {
            return attributes.get(name);
        }

        @Override
        public Object getValue(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String[] getValueNames() {
            return new String[0];
        }

        @Override public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        @Override
        public void putValue(String s, Object o) {

        }

        @Override
        public void removeAttribute(String s) {

        }

        @Override
        public void removeValue(String s) {

        }

        @Override
        public void invalidate() {

        }

        @Override
        public boolean isNew() {
            return false;
        }

        // rest ignored for brevity
    }

    static class MockResponse implements HttpServletResponse {
        private final StringWriter body = new StringWriter();
        private int status = 200;

        @Override
        public String getCharacterEncoding() {
            return "";
        }

        @Override
        public String getContentType() {
            return "";
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return null;
        }

        @Override public PrintWriter getWriter() {
            return new PrintWriter(body);
        }

        @Override
        public void setCharacterEncoding(String s) {

        }

        @Override
        public void setContentLength(int i) {

        }

        @Override
        public void setContentLengthLong(long l) {

        }

        @Override
        public void setContentType(String s) {

        }

        @Override
        public void setBufferSize(int i) {

        }

        @Override
        public int getBufferSize() {
            return 0;
        }

        @Override
        public void flushBuffer() throws IOException {

        }

        @Override
        public void resetBuffer() {

        }

        @Override
        public boolean isCommitted() {
            return false;
        }

        @Override
        public void reset() {

        }

        @Override
        public void setLocale(Locale locale) {

        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public void addCookie(Cookie cookie) {

        }

        @Override
        public boolean containsHeader(String s) {
            return false;
        }

        @Override
        public String encodeURL(String s) {
            return "";
        }

        @Override
        public String encodeRedirectURL(String s) {
            return "";
        }

        @Override
        public String encodeUrl(String s) {
            return "";
        }

        @Override
        public String encodeRedirectUrl(String s) {
            return "";
        }

        @Override
        public void sendError(int i, String s) throws IOException {

        }

        @Override
        public void sendError(int i) throws IOException {

        }

        @Override
        public void sendRedirect(String s) throws IOException {

        }

        @Override
        public void setDateHeader(String s, long l) {

        }

        @Override
        public void addDateHeader(String s, long l) {

        }

        @Override
        public void setHeader(String s, String s1) {

        }

        @Override
        public void addHeader(String s, String s1) {

        }

        @Override
        public void setIntHeader(String s, int i) {

        }

        @Override
        public void addIntHeader(String s, int i) {

        }

        @Override public void setStatus(int sc) {
            this.status = sc;
        }

        @Override
        public void setStatus(int i, String s) {

        }

        public int getStatus() {
            return status;
        }

        @Override
        public String getHeader(String s) {
            return "";
        }

        @Override
        public Collection<String> getHeaders(String s) {
            return List.of();
        }

        @Override
        public Collection<String> getHeaderNames() {
            return List.of();
        }

        public String getBody() {
            return body.toString().trim();
        }
    }

    // -------------------- TEST CASES --------------------

    @Test
    public void testGetGeneratesToken() throws IOException {
        Task135_PERPLEXITY_llama_3_sonar_large_32k_chat servlet = new Task135_PERPLEXITY_llama_3_sonar_large_32k_chat();
        MockRequest request = new MockRequest();
        MockResponse response = new MockResponse();

        servlet.doGet(request, response);

        String token = (String) request.getSession().getAttribute("_csrf_token");
        assertNotNull(token, "CSRF token should be stored in session");

        assertTrue(response.getBody().contains(token), "CSRF token should be included in HTML form");
    }

    @Test
    public void testValidCsrfPost() throws IOException {
        Task135_PERPLEXITY_llama_3_sonar_large_32k_chat servlet = new Task135_PERPLEXITY_llama_3_sonar_large_32k_chat();
        MockRequest request = new MockRequest();
        MockResponse response = new MockResponse();

        String token = "test-token-123";
        request.getSession().setAttribute("_csrf_token", token);
        request.setParameter("_csrf_token", token);

        servlet.doPost(request, response);

        assertEquals(200, response.getStatus());
        assertEquals("Form submitted successfully", response.getBody());
    }

    @Test
    public void testInvalidCsrfPost() throws IOException {
        Task135_PERPLEXITY_llama_3_sonar_large_32k_chat servlet = new Task135_PERPLEXITY_llama_3_sonar_large_32k_chat();
        MockRequest request = new MockRequest();
        MockResponse response = new MockResponse();

        request.getSession().setAttribute("_csrf_token", "valid-token");
        request.setParameter("_csrf_token", "invalid-token");

        servlet.doPost(request, response);

        assertEquals(403, response.getStatus());
        assertEquals("CSRF token missing or invalid", response.getBody());
    }
}
