package client

import java.awt.Dimension
import java.awt.image.BufferedImage
import java.rmi.Naming
import java.rmi.server.UnicastRemoteObject

import server.TokyoServer

import scala.swing.MainFrame
import scala.swing.Panel
import scala.swing._

object Client extends UnicastRemoteObject with TokyoClient{

  var img: BufferedImage = null
  val panel = new Panel {
    override def paint(g: Graphics2D) = {
      g.drawImage(img, 0, 0, null)
    }
    preferredSize = new Dimension(500, 500)
  }

  val frame = new MainFrame {
    title = "King of Tokyo"
    contents = panel
    centerOnScreen()
  }

  def main(args: Array[String]): Unit = {
    frame.open()
    val server = Naming.lookup("rmi://localhost/TokyoServer") match {
      case s: TokyoServer => s
      case _ => throw new RuntimeException("Invalid type for RMI server")
    }
    val playerNumber = server.connect(this)
    println(playerNumber)
  }

  override def startGame(): Unit = {}

  override def turn(id: Int): Unit = {}
}
