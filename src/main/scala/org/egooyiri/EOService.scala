package org.egooyiri

import java.io.File
import org.parboiled.common.FileUtils
import scala.concurrent.duration._
import akka.actor._
import akka.pattern.ask
import spray.routing.{HttpService, RequestContext}
import spray.routing.directives.CachingDirectives
import spray.can.server.Stats
import spray.can.Http
import spray.httpx.marshalling.Marshaller
import spray.httpx.encoding.Gzip
import spray.util._
import spray.http._
import MediaTypes._
import CachingDirectives._

// this trait defines our service behavior independently from the service actor
trait EOService extends HttpService {

  val eoRoute = {
    get {
      pathSingleSlash {
        complete(prime)
      } ~
      path("ping") {
        complete("PONG!")
      }
    } ~
    (post | parameter('method ! "post")) {
      path("stop") {
        complete {
          "Shutting down in 1 second..."
        }
      }
    }
  }

  lazy val prime =
    <html>
      <body>
        <h1>Say Manao Ahaona to <i>spray-routing</i> on <i>spray-can</i>!</h1>
        <p>Defined resources:</p>
        <ul>
          <li><a href="/ping">/ping</a></li>
          <li><a href="/stop?method=post">/stop</a></li>
        </ul>
      </body>
    </html>

}