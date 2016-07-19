package fr.lteconsulting;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToggleCarteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String id = request.getParameter( "id" );
		if( id != null )
		{
			Set<String> main = (Set<String>) request.getSession().getAttribute( "main" );
			if( main == null )
			{
				main = new HashSet<>();
				request.getSession().setAttribute( "main", main );
			}

			if( main.contains( id ) )
			{
				main.remove( id );
			}
			else
			{
				if( main.size() < Constantes.NB_MAX_CARTES_PAR_MAIN )
					main.add( id );
			}
		}

		response.sendRedirect( "cartes" );
	}
}
