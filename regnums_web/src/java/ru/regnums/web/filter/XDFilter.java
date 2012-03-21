/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.regnums.web.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1
 */
public class XDFilter implements Filter {
    
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    private final static String ACCESS_CONTROL_HEADER = "Access-Control-Allow-Origin";
    private final static String ACCESS_CONTROL_METHOD = "Access-Control-Allow-Methods";
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String domain_name = "*";
        String method_name = "POST, GET";
        try
        {
            if(this.filterConfig.getInitParameter("allow_domain_name") != null)
            {
                domain_name = this.filterConfig.getInitParameter("allow_domain_name");
            }
            if(this.filterConfig.getInitParameter("allow_method") != null)
            {
                method_name = this.filterConfig.getInitParameter("allow_method");
            }
            if(!httpResponse.containsHeader(ACCESS_CONTROL_HEADER)){
                httpResponse.addHeader(ACCESS_CONTROL_HEADER, domain_name);
            }
            if(!httpResponse.containsHeader(ACCESS_CONTROL_METHOD)){
                httpResponse.addHeader(ACCESS_CONTROL_METHOD, method_name);
            }
        }catch(Exception e){
            e.printStackTrace();
        }                
        chain.doFilter(request, response);        
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;        
    }    
}
