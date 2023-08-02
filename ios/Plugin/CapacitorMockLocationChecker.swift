import Foundation

@objc public class CapacitorMockLocationChecker: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
