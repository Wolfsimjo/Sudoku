import json

import webapp2
import random

from grids import grids

class MainHandler(webapp2.RequestHandler):

	def post(self):
		self.response.headers['Content-Type'] = "application/json"
		difficulty = self.request.params['req']
		grid = grids[difficulty]
		gridNb = random.randrange(len(grid)) + 1
		retGrid = grid["grille"+str(gridNb)]

		self.response.write(json.dumps(retGrid))


app = webapp2.WSGIApplication([
	('/', MainHandler),
], debug=True)

