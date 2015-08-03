package shared

import client.TokyoClient

case class Player(id: Int, client: TokyoClient, lives: Int, points: Int)
