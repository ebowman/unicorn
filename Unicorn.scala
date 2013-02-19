
import java.util.concurrent.ConcurrentHashMap
import scala.collection.JavaConverters._
import scala.util.control.Exception._

object Unicorn {
  val set = new ConcurrentHashMap[String, String]().asScala

  def pat(): Boolean = {
    (allCatch either sys.error("")) match {
      case Left(ex) =>
        val trace = ex.getStackTrace.mkString("\n")
        set.putIfAbsent(trace, trace).isEmpty
    }
  }
}
