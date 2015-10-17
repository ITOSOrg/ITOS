package com.company.itos.profile.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.itos.profile.pojo.PersonDetail;

import com.company.itos.profile.dao.SearchPersonDAO;
import com.company.itos.profile.pojo.PersonSearchCriteria;
import com.company.itos.profile.pojo.PersonSearchDetails;
import com.company.itos.profile.pojo.PersonSearchResult;

/**
 * Servlet implementation class SearchPerson
 */
public class SearchPerson extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchPerson() {

		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		

			PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria();
			personSearchCriteria.setFirstName(firstName == null ? "" : firstName);
			personSearchCriteria.setMiddleName(middleName == null ? "" : middleName);
			personSearchCriteria.setLastName(lastName == null ? "" : lastName);

			PersonSearchDetails personSearchDetails = new PersonSearchDetails();
			personSearchDetails.setPersonSearchCriteria(personSearchCriteria);

			//
			SearchPersonDAO searchPersonDAO = new SearchPersonDAO();

			//
			List<PersonDetail> personDetailList = searchPersonDAO.searchPersonInfo(personSearchDetails);

			long numberOfPerson = personDetailList.size();

			PersonSearchResult personSearchResult = new PersonSearchResult();

			personSearchResult.setNumberOfPerson(numberOfPerson);
			personSearchResult.setPersonDetailList(personDetailList);

			personSearchDetails.setPersonSearchResult(personSearchResult);

			request.setAttribute("personSearchDetails", personSearchDetails);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SearchedPersonInforamation.jsp");
			requestDispatcher.forward(request, response);
		}
	}
