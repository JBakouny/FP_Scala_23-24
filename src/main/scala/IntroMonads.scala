object IntroMonads {
	val l1 = List(1, 2, 3)                    //> l1  : List[Int] = List(1, 2, 3)
	val l2 = List(10, 20, 30)                 //> l2  : List[Int] = List(10, 20, 30)
	
	l1.map(x => x * 5)                        //> res0: List[Int] = List(5, 10, 15)
	l1.flatMap(x => List(x * 5))              //> res1: List[Int] = List(5, 10, 15)
	
	l1.flatMap(x =>
		l2.map(y =>
			x + y
			)
		)                                 //> res2: List[Int] = List(11, 21, 31, 12, 22, 32, 13, 23, 33)

	for {
		x <- l1
		y <- l2
	} yield x + y                             //> res3: List[Int] = List(11, 21, 31, 12, 22, 32, 13, 23, 33)
	
	val emptyList : List[Int] = List()        //> emptyList  : List[Int] = List()
	
	for {
		x <- l1
		y <- emptyList
	} yield x + y                             //> res4: List[Int] = List()
	
	
	val o1 = Option(3)                        //> o1  : Option[Int] = Some(3)
	val o2 = Option(30)                       //> o2  : Option[Int] = Some(30)
	
	o1.map(x => x * 5)                        //> res5: Option[Int] = Some(15)
	o1.flatMap(x => Option(x * 5))            //> res6: Option[Int] = Some(15)
	
	o1.flatMap(x =>
		o2.map(y =>
			x + y
			)
		)                                 //> res7: Option[Int] = Some(33)

	for {
		x <- o1
		y <- o2
	} yield x + y                             //> res8: Option[Int] = Some(33)
	
	val emptyOption : Option[Int] = None      //> emptyOption  : Option[Int] = None
	
	for {
		x <- o1
		y <- emptyOption
	} yield x + y                             //> res9: Option[Int] = None
	
	import scala.util.Success
	import scala.util.Failure
	import scala.util.Try
	
	val t1 = Try(3)                           //> t1  : scala.util.Try[Int] = Success(3)
	val t2 = Try(30)                          //> t2  : scala.util.Try[Int] = Success(30)
	
	t1.map(x => x * 5)                        //> res10: scala.util.Try[Int] = Success(15)
	t1.flatMap(x => Try(x * 5))               //> res11: scala.util.Try[Int] = Success(15)
	
	t1.flatMap(x =>
		t2.map(y =>
			x + y
			)
		)                                 //> res12: scala.util.Try[Int] = Success(33)

	for {
		x <- t1
		y <- t2
	} yield x + y                             //> res13: scala.util.Try[Int] = Success(33)
	
	val exceptionTry : Try[Int] = Try(1/0)    //> exceptionTry  : scala.util.Try[Int] = Failure(java.lang.ArithmeticException:
                                                  //|  / by zero)
	
	for {
		x <- t1
		y <- exceptionTry
	} yield x + y                             //> res14: scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zer
                                                  //| o)

	import scala.concurrent.Future
	import scala.concurrent.ExecutionContext
	implicit val ec : ExecutionContext = ExecutionContext.global //> ec  : scala.concurrent.ExecutionContextExecutor = scala.concurrent.impl.Exe
                                                  //| cutionContextImpl@153f5a29
	val f1 = Future(3)                        //> f1  : scala.concurrent.Future[Int] = Future(<not completed>)
	val f2 = Future(30)                       //> f2  : scala.concurrent.Future[Int] = Future(<not completed>)
	
	val result0 = f1.map(x => x * 5)          //> result0  : scala.concurrent.Future[Int] = Future(<not completed>)
	val result1 = f1.flatMap(x => Future(x * 5))
                                                  //> result1  : scala.concurrent.Future[Int] = Future(<not completed>)
	
	val result2 =
	f1.flatMap(x =>
		f2.map(y =>
			x + y
			)
		)                                 //> result2  : scala.concurrent.Future[Int] = Future(<not completed>)

	val result3 =
	for {
		x <- f1
		y <- f2
	} yield x + y                             //> result3  : scala.concurrent.Future[Int] = Future(<not completed>)
	
	val exceptionFuture : Future[Int] = Future(1/0)
                                                  //> exceptionFuture  : scala.concurrent.Future[Int] = Future(<not completed>)
	
	val result4 =
	for {
		x <- f1
		y <- exceptionFuture
	} yield x + y                             //> result4  : scala.concurrent.Future[Int] = Future(<not completed>)
	
	import scala.concurrent.Await
	import scala.concurrent.duration._

	// Note: using Await is not recommended, read: https://docs.scala-lang.org/overviews/core/futures.html
	
	
	println("result0 = ")                     //> result0 = 
	Await.ready(result0, 100 seconds);        //> res15: collections.IntroMonads.result0.type = Future(Success(15))
	println("result1 = ")                     //> result1 = 
	Await.ready(result1, 100 seconds);        //> res16: collections.IntroMonads.result1.type = Future(Success(15))

	println("result2 = ")                     //> result2 = 
	Await.ready(result2, 100 seconds);        //> res17: collections.IntroMonads.result2.type = Future(Success(33))

	println("result3 = ")                     //> result3 = 
	Await.ready(result3, 100 seconds);        //> res18: collections.IntroMonads.result3.type = Future(Success(33))

	println("result4 = ")                     //> result4 = 
	Await.ready(result4, 100 seconds);        //> res19: collections.IntroMonads.result4.type = Future(Failure(java.lang.Arit
                                                  //| hmeticException: / by zero))

	
}
