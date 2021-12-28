import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

object ApiMain extends App {

  implicit val system = ActorSystem(Behaviors.empty, "ApiMain")

  implicit val executionContext = system.executionContext

  val route =
    path("health") {
      get {
        complete("OK!")
      }
    }

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)
  sys.addShutdownHook {
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }

}
