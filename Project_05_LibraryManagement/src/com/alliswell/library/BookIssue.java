
package com.alliswell.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookIssue
 */
@WebServlet("/BookIssue")
public class BookIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookname");
		String author = request.getParameter("author");
		String dateofIssue = request.getParameter("dateOfIssue");
		String dateofReturn = request.getParameter("dateOfReturn");

		try {
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();

			session.setAttribute("bookname", bookName);
			session.setAttribute("author", author);
			session.setAttribute("dateOfIssue", dateofIssue);
			session.setAttribute("dateOfReturn", dateofReturn);

			out.println("Book Name : " + bookName);
			out.println("Author : " + author);
			out.println("Date Of Issue : " + dateofIssue);
			out.println("Date Of Return : " + dateofReturn);

			response.sendRedirect("printOut.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
