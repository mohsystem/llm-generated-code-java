package claude.task135;

import org.junit.jupiter.api.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task135Test {

    static class SimpleHttpServletRequest extends HttpServletRequestAdapter {
        private final Map<String, String> parameters = new HashMap<>();
        private final HttpSession session = new SimpleHttpSession();

        public void setParameter(String key, String value) {
            parameters.put(key, value);
        }

        @Override
        public String getParameter(String name) {
            return parameters.get(name);
        }

        @Override
        public HttpSession getSession() {
            return session;
        }

        @Override
        public HttpSession getSession(boolean create) {
            return session;
        }
    }

    static class SimpleHttpServletResponse extends HttpServletResponseAdapter {
        private final StringWriter output = new StringWriter();
        private int status = 200;

        @Override
        public PrintWriter getWriter() {
            return new PrintWriter(output);
        }

        public String getOutput() {
            return output.toString().trim();
        }

        @Override
        public void setStatus(int sc) {
            this.status = sc;
        }

        @Override
        public int getStatus() {
            return status;
        }
    }

    static class SimpleHttpSession implements HttpSession {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override public Object getAttribute(String name) { return attributes.get(name); }
        @Override public void setAttribute(String name, Object value) { attributes.put(name, value); }
        @Override public Enumeration<String> getAttributeNames() { return Collections.enumeration(attributes.keySet()); }

        // No-op for unneeded methods
        public long getCreationTime() { return 0; }
        public String getId() { return "mock"; }
        public long getLastAccessedTime() { return 0; }
        public ServletContext getServletContext() { return null; }
        public void setMaxInactiveInterval(int i) {}
        public int getMaxInactiveInterval() { return 0; }
        public HttpSessionContext getSessionContext() { return null; }
        public Object getValue(String name) { return null; }
        public String[] getValueNames() { return new String[0]; }
        public void putValue(String name, Object value) {}
        public void removeAttribute(String name) { attributes.remove(name); }
        public void removeValue(String name) {}
        public void invalidate() {}
        public boolean isNew() { return false; }
    }

    // Stub classes to satisfy constructor signatures
    static class HttpServletRequestAdapter implements HttpServletRequest {
        @Override public String getAuthType() { return null; }
        @Override public Cookie[] getCookies() { return new Cookie[0]; }
        @Override public long getDateHeader(String name) { return 0; }
        @Override public String getHeader(String name) { return null; }
        @Override public Enumeration<String> getHeaders(String name) { return null; }
        @Override public Enumeration<String> getHeaderNames() { return null; }
        @Override public int getIntHeader(String name) { return 0; }
        @Override public String getMethod() { return "POST"; }
        @Override public String getPathInfo() { return null; }
        @Override public String getPathTranslated() { return null; }
        @Override public String getContextPath() { return null; }
        @Override public String getQueryString() { return null; }
        @Override public String getRemoteUser() { return null; }
        @Override public boolean isUserInRole(String role) { return false; }
        @Override public java.security.Principal getUserPrincipal() { return null; }
        @Override public String getRequestedSessionId() { return null; }
        @Override public String getRequestURI() { return null; }
        @Override public StringBuffer getRequestURL() { return null; }
        @Override public String getServletPath() { return null; }
        @Override public HttpSession getSession(boolean create) { return null; }
        @Override public HttpSession getSession() { return null; }
        @Override public String changeSessionId() { return null; }
        @Override public boolean isRequestedSessionIdValid() { return false; }
        @Override public boolean isRequestedSessionIdFromCookie() { return false; }
        @Override public boolean isRequestedSessionIdFromURL() { return false; }
        @Override public boolean isRequestedSessionIdFromUrl() { return false; }
        @Override public boolean authenticate(HttpServletResponse response) { return false; }
        @Override public void login(String username, String password) {}
        @Override public void logout() {}
        @Override public Collection<Part> getParts() { return null; }
        @Override public Part getPart(String name) { return null; }
        @Override public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) { return null; }

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

        @Override
        public String getParameter(String s) {
            return "";
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
        // Others not used for this test
    }

    static class HttpServletResponseAdapter implements HttpServletResponse {
        @Override public void addCookie(Cookie cookie) {}
        @Override public boolean containsHeader(String name) { return false; }
        @Override public String encodeURL(String url) { return null; }
        @Override public String encodeRedirectURL(String url) { return null; }
        @Override public String encodeUrl(String url) { return null; }
        @Override public String encodeRedirectUrl(String url) { return null; }
        @Override public void sendError(int sc, String msg) {}
        @Override public void sendError(int sc) {}
        @Override public void sendRedirect(String location) {}
        @Override public void setDateHeader(String name, long date) {}
        @Override public void addDateHeader(String name, long date) {}
        @Override public void setHeader(String name, String value) {}
        @Override public void addHeader(String name, String value) {}
        @Override public void setIntHeader(String name, int value) {}
        @Override public void addIntHeader(String name, int value) {}
        @Override public void setStatus(int sc) {}
        @Override public void setStatus(int sc, String sm) {}

        @Override
        public int getStatus() {
            return 0;
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

        @Override
        public PrintWriter getWriter() throws IOException {
            return null;
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
        // Not used in test
    }

    @Test
    public void testValidCSRFSubmission() throws ServletException, IOException {
        Task135_CLAUDE_claude_3_5_sonnet_20240620 servlet = new Task135_CLAUDE_claude_3_5_sonnet_20240620();

        // simulate GET to generate token
        SimpleHttpServletRequest getReq = new SimpleHttpServletRequest();
        SimpleHttpServletResponse getRes = new SimpleHttpServletResponse();
        servlet.doGet(getReq, getRes);

        String token = (String) getReq.getSession().getAttribute("csrfToken");
        assertNotNull(token);

        // simulate POST with valid token
        SimpleHttpServletRequest postReq = new SimpleHttpServletRequest();
        postReq.setParameter("csrfToken", token);
        postReq.getSession().setAttribute("csrfToken", token);

        SimpleHttpServletResponse postRes = new SimpleHttpServletResponse();
        servlet.doPost(postReq, postRes);

        assertEquals(200, postRes.getStatus());
        assertEquals("Form submitted successfully!", postRes.getOutput());
    }

    @Test
    public void testInvalidCSRFSubmission() throws ServletException, IOException {
        Task135_CLAUDE_claude_3_5_sonnet_20240620 servlet = new Task135_CLAUDE_claude_3_5_sonnet_20240620();

        // simulate POST with wrong token
        SimpleHttpServletRequest postReq = new SimpleHttpServletRequest();
        postReq.setParameter("csrfToken", "fake-token");
        postReq.getSession().setAttribute("csrfToken", "real-token");

        SimpleHttpServletResponse postRes = new SimpleHttpServletResponse();
        servlet.doPost(postReq, postRes);

        assertEquals(403, postRes.getStatus());
        assertEquals("CSRF token validation failed", postRes.getOutput());
    }
}
