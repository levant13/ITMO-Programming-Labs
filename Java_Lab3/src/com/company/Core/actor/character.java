package com.company.Core.actor;
import Utility.AbstractHuman;
import com.company.Core.sources.*;
import com.company.Utility.ActionInterface;
import com.company.Utility.WrongInstanceException;
import com.company.Utility.WrongNameException;

import java.util.Objects;

public class character extends AbstractHuman {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) throws WrongNameException {
        if (name == "Shpuntik and Toropyzhka") {
            this.name = name;
            joinStory();
        } else {
            throw new WrongNameException("Wrong name of Shpuntik and Toropyzhka");
        }
    }

    public character() {
        super();
    }

    private void joinStory() {
        System.out.println(name + " join in story");
    }

    public void becomeAstronomer() {
        System.out.println(name + " became an astronomer");
    }


    public static class Climb {
        private Object name;

        public void ClimbBush(String name) {
            ActionInterface ClimbBush = new ActionInterface() {
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
                public String AcInterface(String name) {
                    System.out.println("Now, " + name + "Climb the bushes ");
                    return name;
                }
            };
            ClimbBush.AcInterface(name);
        }

        public static class Pull {
            public void pull(String name) {
                Pull action_pull = new Pull() {

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
                        System.out.println(name + "Pull the ball up ");

                    }
                };
                action_pull.pull(name);
            }
        }

        // static inner class
        static class Vision {
            // Edit the code beautifully here
            private static void climbthebush(String name) {
                Bush climbBush = new Bush();
                climbBush.AcInterface(name);
            }

            private static void pullball(String name) {
                Ball PullBall = new Ball();
                PullBall.pull(name);
            }

            private static void pullBasket(String name) {
                Basket pullB = new Basket();
                pullB.pull(name);
            }
        }

        // Using static classes
        public void climbthebush(String name) {
            Vision.climbthebush(name);
        }

        public void pullball(String name) {
            Vision.pullball(name);
        }

        public void pullBasket(String name) {
            Vision.pullBasket(name);
        }
    }


        public void getAttention(AbstractHuman someone) throws WrongInstanceException {
            if (someone instanceof Znayka) {
                attention(someone);
            } else {
                throw new WrongInstanceException("Only Znayka is given orders");
            }
        }
        private void attention(AbstractHuman someone) {
            System.out.println("Listen "+ someone.getName()+"!");
        }
        @Override
        public String toString() {
            return "He{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object object) {
            return super.equals(name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

}
