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

object EOServiceActor {
  sealed trait OperationReply
  case class OperationAck(id: Long) extends OperationReply

}

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class EOServiceActor extends Actor with EOService with DemoService {
  import EOServiceActor._

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context
  
  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = {
    case OperationAck(id: Long) =>
      context.become(demoRouteBehavior)
    case _   => 
      context.become(eoRouteBehavior)
  }
  
  // this is where you can expand your own behaviors  
  def eoRouteBehavior:          Receive = runRoute(eoRoute)
  def demoRouteBehavior:        Receive = runRoute(demoRoute)
  def maintenanceRouteBehavior: Receive = {
                                  case _ =>
                                }

}
