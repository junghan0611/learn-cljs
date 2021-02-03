(ns notes.ui.notifications
  (:require [reagent.core :as r]
            [notes.ui.animation :as animation]
            [notes.state :refer [app]]
            [notes.command :refer [dispatch!]]))

(defn notifications []
  (let [messages (r/cursor app [:notifications :messages])]
    (fn []
      [:div.messages
       (for [msg @messages
             :let [{:keys [id type text]} msg]]
         ^{:key id}
         [animation/slide-in {:direction :top}
          [:div {:class (str "notification is-" (name type))}
           [:button.delete {:on-click #(dispatch! :notification/remove id)}]
           [:div.body text]]])])))
