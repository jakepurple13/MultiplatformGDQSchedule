import UIKit
import common
import SwiftSoup

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = PlatformKt.MainViewController(
            setup: { (html) in
                do {
                    let doc: Document = try SwiftSoup.parse(html as String)
                    return try doc
                        .select("table#runTable")
                        .select("tr, tr.second-row")
                        .dropFirst()
                        .enumerated()
                        .map { (index, g) in
                            do {
                                if(index % 2 == 0) {
                                    return GameInfo.Game(
                                            game: try g.select("tr > td").get(1).text(),
                                            runner: try g.select("tr > td").get(2).text(),
                                            startTime: try g.select("tr > td.start-time").text()
                                    )
                                } else {
                                    return GameInfo.Info(
                                        time: try g.select("tr.second-row > td.text-right").text(),
                                        info: try g.select("tr.second-row > td").get(1).text()
                                    )
                                }
                            } catch Exception.Error(_, let message) {
                                print(message)
                                return GameInfo.Game(
                                    game: "",
                                    runner: "",
                                    startTime: ""
                                )
                            } catch {
                                print("error")
                                return GameInfo.Game(
                                    game: "",
                                    runner: "",
                                    startTime: ""
                                )
                            }
                        }// as! KotlinArray<NSString>
                } catch {
                    return [""]//KotlinArray<NSString>(size: 0, init: { _ in "" })
                }
            }
        )
        window?.rootViewController = mainViewController
        window?.makeKeyAndVisible()
        return true
    }
}
