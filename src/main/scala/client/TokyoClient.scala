package client

import java.rmi.{Remote, RemoteException}

trait TokyoClient extends Remote {
  @throws(classOf[RemoteException]) def startGame(): Unit
  @throws(classOf[RemoteException]) def turn(id: Int)
}
