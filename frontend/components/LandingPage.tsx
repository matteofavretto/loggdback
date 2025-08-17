"use client";

import { useState } from "react";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "./ui/tabs";
import { Gamepad2 } from "lucide-react";

export default function App() {
  const [activeTab, setActiveTab] = useState("");

  return (
    <div className="min-h-screen bg-background">
      {/* Top Navigation Bar */}
      <nav className="border-b border-border bg-card">
        <div className="container mx-auto px-4">
          <Tabs value={activeTab} onValueChange={setActiveTab} className="w-full">
            <TabsList className="grid w-full max-w-md grid-cols-3 mx-auto bg-transparent h-16">
              <TabsTrigger 
                value="my-lists" 
                className="data-[state=active]:bg-primary data-[state=active]:text-primary-foreground"
              >
                My Lists
              </TabsTrigger>
              <TabsTrigger 
                value="browse"
                className="data-[state=active]:bg-primary data-[state=active]:text-primary-foreground"
              >
                Browse
              </TabsTrigger>
              <TabsTrigger 
                value="profile"
                className="data-[state=active]:bg-primary data-[state=active]:text-primary-foreground"
              >
                Profile
              </TabsTrigger>
            </TabsList>

            {/* Main Content Area */}
            <div className="container mx-auto px-4 py-8">
              {/* Default landing page content when no tab is selected */}
              {!activeTab && (
                <div className="flex flex-col items-center justify-center min-h-[60vh] space-y-6">
                  <div className="flex items-center justify-center w-32 h-32 bg-muted rounded-lg">
                    <Gamepad2 size={64} className="text-muted-foreground" />
                  </div>
                  <div className="text-center space-y-2">
                    <h1 className="text-2xl font-medium text-foreground">Game Backlog Manager</h1>
                    <p className="text-muted-foreground max-w-md">
                      Organize your gaming collection, track your backlog, and discover new games to play.
                    </p>
                  </div>
                </div>
              )}

              {/* Tab Content */}
              <TabsContent value="my-lists" className="mt-0">
                <div className="text-center py-12">
                  <h2 className="text-xl mb-4">My Lists</h2>
                  <p className="text-muted-foreground">Your game lists will appear here.</p>
                </div>
              </TabsContent>

              <TabsContent value="browse" className="mt-0">
                <div className="text-center py-12">
                  <h2 className="text-xl mb-4">Browse Games</h2>
                  <p className="text-muted-foreground">Discover new games to add to your backlog.</p>
                </div>
              </TabsContent>

              <TabsContent value="profile" className="mt-0">
                <div className="text-center py-12">
                  <h2 className="text-xl mb-4">Profile</h2>
                  <p className="text-muted-foreground">Manage your profile and settings.</p>
                </div>
              </TabsContent>
            </div>
          </Tabs>
        </div>
      </nav>
    </div>
  );
}