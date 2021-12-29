package com.company.Core.sources;
import com.company.Utility.EObject;
import com.company.Utility.PullInterface;

    public class Ball implements PullInterface {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
        @Override
        public String toString() {
            return super.toString();
        }
        @Override
        public void pull(String name) {
            System.out.println(name + " pulled the " + EObject.Ball + " out of the " + EObject.Ground);
            System.out.println("That makes the " + EObject.Audience + " very happy ");
        }
    }

